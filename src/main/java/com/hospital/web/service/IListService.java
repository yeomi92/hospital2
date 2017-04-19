package com.hospital.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hospital.web.domain.Chart;
@Service
@FunctionalInterface
public interface IListService {
	public List<Chart> execute(Map<?,?>map)throws Exception;
}
