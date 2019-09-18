package com.ets.service.naicsCode;



import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.naicsCode.NaicsCodeDAO;
import com.ets.model.NAICSCode;

/**
 *Original Author: Sumanta Deyashii on Behalf of ETS for Client Company
 *File Creation Date: 23-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of NaicsCodeServiceImpl Class
 *Description: NAICSCode Entity Service class
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

@Service
@Transactional
public class NaicsCodeServiceImpl implements NaicsCodeService {
	
	private NaicsCodeDAO naicsCodeDAO;

	public void setNaicsCodeDAO(NaicsCodeDAO naicsCodeDAO) {
		this.naicsCodeDAO = naicsCodeDAO;
	}

	/** This method save the NAICSCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param naicsCode
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addNaicsCode(NAICSCode naicsCode) {
		
		naicsCodeDAO.addNaicsCode(naicsCode);
		
		
	}
	/** This method gets all the NAICSCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of NAICSCode objects
	 */
	@Override
	public List<NAICSCode> naicsCodeLists() {
		
		return naicsCodeDAO.naicsCodeLists();
	}
	/** This method update the NAICSCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param naicsCode
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateNAICSCode(NAICSCode naicsCode) {
		
		naicsCodeDAO.updateNAICSCode(naicsCode);
		
	}
	/** This method gets  the NAICSCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of NAICSCode objects
	 */
	@Override
	public NAICSCode getByNAICSCodeID(Integer id) {
		
		return naicsCodeDAO.getByNAICSCodeID(id);
	}
	/** This method delete the NAICSCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void deleteNAICSCode(Integer id) {
		
		naicsCodeDAO.deleteNAICSCode(id);
		
	}

	@Override
	public NAICSCode viewByCode(String code) {
		// TODO Auto-generated method stub
		return naicsCodeDAO.viewByCode(code);
	}
	
	

}
