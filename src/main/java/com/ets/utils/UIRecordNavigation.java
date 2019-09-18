package com.ets.utils;

/*
 *Original Author: Shazarin Farha on Behalf of ETS for Client Company
 *File Creation Date: 02-05-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of UIRecordNavigation Class
 *Description: Used for record navigation in UI .
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 */

import javafx.scene.control.TableView;

public class UIRecordNavigation {
	
	public static void setPosition( TableView dataTable , int position ){
		dataTable.getSelectionModel().select( position );
		dataTable.requestFocus();
	}

}
