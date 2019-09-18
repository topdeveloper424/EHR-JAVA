package com.ets.utils;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.ListView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

/**
 *Original Author: Indronil Chaudhuri on Behalf of ETS for Client Company
 *File Creation Date: 05-11-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of DragDrop Class
 *Description: DragDrop Utility class
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

public class DragDrop {
	/*private DragEvent event ;
	private ListView<String> listView;
	
	public DragDrop(DragEvent event, ListView<String> listView)	{
		this.event = event ;
		this.listView = listView ;
	}
	
	private void dragDetected(MouseEvent event)	{
		// Make sure at least one item is selected
		int selectedCount = listView.getSelectionModel().getSelectedIndices().size();

		if (selectedCount == 0)	{
			event.consume();
			return;
		}

		// Initiate a drag-and-drop gesture
		Dragboard dragboard = listView.startDragAndDrop(TransferMode.COPY_OR_MOVE);

		// Put the the selected items to the dragboard
		ArrayList<String> selectedItems = this.getSelectedFruits(listView);

		ClipboardContent content = new ClipboardContent();
		content.put(FRUIT_LIST, selectedItems);

		dragboard.setContent(content);
		event.consume();
	}

	private void dragOver()	{
		// If drag board has an ITEM_LIST and it is not being dragged
		// over itself, we accept the MOVE transfer mode
		Dragboard dragboard = event.getDragboard();

		if (event.getGestureSource() != listView && dragboard.hasContent(FRUIT_LIST))	{
			event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
		}

		event.consume();
	}

	@SuppressWarnings("unchecked")
	private void dragDropped()	{
		boolean dragCompleted = false;

		// Transfer the data to the target
		Dragboard dragboard = event.getDragboard();

		if(dragboard.hasContent(FRUIT_LIST))	{
			ArrayList<String> list = (ArrayList<String>)dragboard.getContent(FRUIT_LIST);
			listView.getItems().addAll(list);
			// Data transfer is successful
			dragCompleted = true;
		}

		// Data transfer is not successful
		event.setDropCompleted(dragCompleted);
		event.consume();
	}

	private void dragDone()	{
		// Check how data was transfered to the target
		// If it was moved, clear the selected items
		TransferMode tm = event.getTransferMode();

		if (tm == TransferMode.MOVE)	{
			removeSelectedFruits(listView);
		}

		event.consume();
	}
	
	private void removeSelectedFruits()		{
		// Get all selected Fruits in a separate list to avoid the shared list issue
		List<String> selectedList = new ArrayList<>();

		for(String fruit : listView.getSelectionModel().getSelectedItems())	{
			selectedList.add(fruit);
		}

		// Clear the selection
		listView.getSelectionModel().clearSelection();
		// Remove items from the selected list
		listView.getItems().removeAll(selectedList);
	}*/
}