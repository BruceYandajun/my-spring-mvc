package com.github.bruce.utils;

import com.alibaba.fastjson.JSON;
import com.github.bruce.model.Image;
import com.github.bruce.model.Item;
import com.github.bruce.model.Video;
import com.google.common.collect.Lists;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class ExcelUtil {
    public static void main(String[] args) throws IOException {
        InputStream file;
        XSSFWorkbook workbook;
        final String fileName = "/Users/yandajun/Downloads/6-11.xlsx";
        file = new FileInputStream(fileName);
        workbook = new XSSFWorkbook(file);
        //取第0个单元表
        XSSFSheet sheet = workbook.getSheetAt(0);
        if (sheet == null) {
            System.out.println("文档没有一个sheet页");
            return;
        }
        int rows = sheet.getPhysicalNumberOfRows();
        if (rows == 0) {
            System.out.println("文档没有一行数据");
            return;
        }
        for (int i = 1; i < rows; i++) {
            XSSFRow row = sheet.getRow(i);
            for (int j = 0; j <= 9; j++) {
                XSSFCell cell = row.getCell(j);
                if (cell == null) {
                    System.out.println("第" + (i + 1) + "行" + (j + 1) + "列缺少数据");
//                    continue;
                    return;
                }
                if (j == 3 || j == 5) {
                    String date;
                    try {
                        date = cell.getStringCellValue();
                    } catch (Exception e) {
                        date = cell.getNumericCellValue() + "";
                    }
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                    try {
                        sdf.parse(date);
                    } catch (ParseException e) {
                        System.out.println("第" + (i + 1) + "行" + (j + 1) + "列时间格式不正确:" + date);
                        return;
                    }
                }
                if (j == 9) {
                    String url;
                    try {
                        url = cell.getStringCellValue();
                    } catch (Exception e) {
                        url = cell.getNumericCellValue() + "";
                    }
                    if (url.lastIndexOf(".") == -1) {
                        System.out.println("第" + (i + 1) + "行" + (j + 1) + "列url不正确:" + url);
                        return;
                    }
                }
            }
        }
        Map<String, Item> itemMap = new HashMap<>();
        for (int i = 1; i < rows; i++) {
            XSSFRow row = sheet.getRow(i);
            String item_id;
            try {
                item_id = (int)row.getCell(1).getNumericCellValue() + "";
            } catch (IllegalStateException e) {
                item_id = row.getCell(1).getStringCellValue().trim();
            }
            Item item = itemMap.get(item_id);
            if (item == null) {
                item = new Item();
                item.setItem_id(item_id);
                item.setPublish_time(row.getCell(3).getStringCellValue().trim());
                item.setSource("VIPKID");
                item.setTitle(row.getCell(0).getStringCellValue().trim());
                item.setVideos(Lists.newArrayList());
                item.setImages(Collections.singletonList(Image.of("https://s.vipkidstatic.com/fe-static/pc/parents/img/common/header/logo-copy-5f3d71704a.png")));
                itemMap.put(item_id, item);
            }
            Video video = new Video();
            try {
                video.setItem_id((int)row.getCell(4).getNumericCellValue() + "");
            } catch (IllegalStateException e) {
                video.setItem_id(row.getCell(4).getStringCellValue().trim());
            }
            String url = row.getCell(9).getStringCellValue().trim();
            video.setUrl(url);
            video.setFormat(url.substring(url.lastIndexOf(".") + 1));
            try {
                video.setSize((int)row.getCell(6).getNumericCellValue());
            } catch (IllegalStateException e) {
                video.setSize(Integer.parseInt(row.getCell(6).getStringCellValue().trim()));
            }
            try {
                video.setDuration((int)row.getCell(7).getNumericCellValue());
            } catch (IllegalStateException e) {
                video.setDuration(Integer.parseInt(row.getCell(7).getStringCellValue().trim()));
            }
            try {
                video.setSn((int)row.getCell(2).getNumericCellValue());
            } catch (IllegalStateException e) {
                video.setSn(Integer.parseInt(row.getCell(2).getStringCellValue().trim()));
            }
            video.setTitle(row.getCell(8).getStringCellValue().trim());
            item.getVideos().add(video);
        }
        List<Item> items = itemMap.values().stream().sorted(Comparator.comparing(Item::getItem_id)).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(items));
    }

}

