package com.ets.service.firstResponse;

import java.util.List;

import com.ets.model.FirstResponse;

public interface FirstResponseService {

	public void addFirstResponse(FirstResponse firstResponse);

	public List<FirstResponse> firstResponseList();

	public void updateFirstResponse(FirstResponse firstResponse);

	public FirstResponse getbyFirstResponseID(Integer id);

	public void dleteFirstResponse(Integer id);

}
