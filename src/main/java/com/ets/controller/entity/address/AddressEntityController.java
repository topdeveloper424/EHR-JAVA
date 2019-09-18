package com.ets.controller.entity.address;


import com.ets.model.Address;
import com.ets.service.address.AddressServiceImpl;
import com.ets.utils.Global;

public class AddressEntityController {

	//private static ClassPathXmlApplicationContext context;
	private AddressServiceImpl addressServiceImpl;

	public AddressEntityController() {
		
		addressServiceImpl = (AddressServiceImpl) Global.context.getBean("addressService");
	}

	public void closeApplicationContext() {
		//this.context.close();
	}

	public void add(Address address) {

		addressServiceImpl.add(address);
		//this.closeApplicationContext();
	}
	
	public void update(Address address){
		
		addressServiceImpl.update(address);
		//this.closeApplicationContext();
		
	}

}
