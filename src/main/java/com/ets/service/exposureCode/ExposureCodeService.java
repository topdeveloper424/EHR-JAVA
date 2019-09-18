package com.ets.service.exposureCode;

import java.util.List;

import com.ets.model.ExposureCode;

public interface ExposureCodeService {

	public void addExposureCode(ExposureCode exposureCode);

	public List<ExposureCode> exposureCodeList();

	public void updateExposureCode(ExposureCode exposureCode);

	public ExposureCode getByExposureCodeID(Integer id);

	public void deleteExposureCode(Integer id);

}
