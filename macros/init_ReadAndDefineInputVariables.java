
http://opencsv.sourceforge.net/xref-test/integrationTest/issue3189428/CsvSample.html
4   import com.opencsv.CSVParser;
5   import com.opencsv.CSVReader;
6   import com.opencsv.CSVWriter;
7   import com.opencsv.bean.ColumnPositionMappingStrategy;
8   import com.opencsv.bean.CsvToBean;
9   
10  import java.io.FileNotFoundException;
11  import java.io.FileReader;
12  import java.io.FileWriter;
13  import java.io.IOException;
14  import java.util.List;



Reader in = new FileReader("input1.csv");
    Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
    for (CSVRecord record : records) {
      System.out.println(record.get(0));
    }


http://opencsv.sourceforge.net/#how-to-read
    CSVReader reader = new CSVReader(new FileReader("yourfile.csv"));
     List myEntries = reader.readAll();


     // from http://www.mysamplecode.com/2012/04/java-parse-csv-file-import.html

      Sample Java program that parses a CSV file

package com.as400samplecode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
// or
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import au.com.bytecode.opencsv.bean.CsvToBean;
import au.com.bytecode.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;