package com.mortgage.leads.utils.threading;

import com.mortgage.leads.utils.exception.LeadsException;

public interface CorporateActions {

	public void processNotifcationRequest(int requestCount) throws LeadsException;

}
