package com.ets.service.illnessCode;

import java.util.List;

import com.ets.model.IllnessCode;

public interface IllnessCodeService {

	public void addIllnessCode(IllnessCode illnessCode);

	public List<IllnessCode> illnessCodeList();

	public void updateIllnessCode(IllnessCode illnessCode);

	public IllnessCode getByIllnessCodeID(Integer id);

	public void deleteIllnessCode(Integer id);

}
