package com.study.servlet_study.entity;

import com.study.servlet_study.entity.Publisher.PublisherBuilder;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Book {
	private int bookId;
	private String bookName;
	private Author author;
	private Publisher publisher;

}
