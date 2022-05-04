package com.tectoro.ems.controller;

import java.util.List;
import com.tectoro.ems.domain.Depend;
import com.tectoro.ems.service.DependService;
import com.tectoro.ems.service.impl.DependServiceImpl;

public class DependController {
	
	private static DependService dependService = new DependServiceImpl();
	
	public List<Depend> getDependById(int empId){
		List<Depend> depend= null;
		try {
			depend= dependService.getDependById(empId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return depend;	
	}
	public Depend addDepend(Depend depend) {
		
		Depend dependOutput= new Depend();
		try {
			dependOutput= dependService.addDepend(depend);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dependOutput;
	}
	
	public Depend updateDepend(Depend depend) {
		Depend dependOutput= new Depend();
		try {
			dependOutput= dependService.updateDepend(depend);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dependOutput;
	}

	public String delteDepend(int dependId) {
		
		String deleteDepend = dependService.delteDepend(dependId);
		return "delete opereation is done";
		
	}
	
	
	 public static void main(String[] args) {
		
		 DependController dependcontroller = new DependController();
		 List<Depend> depend = new DependController().getDependById(1002);
		 for(Depend depends:depend) {
			 System.out.println();
			 System.out.println("depend id:"+depends.getDependId());
				System.out.println("depend firstname:"+depends.getFirstName());
				System.out.println("depend lastname:"+depends.getLastName());
				System.out.println("depend relation:"+depends.getRelation());
			 
		 }
		 /*
		 System.out.println("==========================");
			Depend insertDepend = new Depend();
			insertDepend.setDependId(7);
			insertDepend.setFirstName("Kalia");
			insertDepend.setLastName("kumar");
			insertDepend.setRelation("brother");
			insertDepend.setEmpId(1003);
			Depend dependtOutput = new DependController().addDepend(insertDepend);
			if(dependtOutput!= null) {
				System.out.println("Insert operation in Depend:-");
				System.out.println("depend id:"+dependtOutput.getDependId()
									+"\t"+"depend firstname:"+dependtOutput.getFirstName()
									+"\t"+"depend lastname:"+dependtOutput.getLastName()
									+"\t"+"depend relation:"+dependtOutput.getRelation()
									+"\t"+"empid:"+dependtOutput.getEmpId());	
			}
			else
			{
				System.out.println("Depend already exists in the database");
			}	
		 */
			
			 System.out.println("==========================");
				Depend updateDepend = new Depend();
				updateDepend.setDependId(7);
				updateDepend.setFirstName("rabi");
				updateDepend.setLastName("kumar");
				updateDepend.setRelation("uncle");
				updateDepend.setEmpId(1003);
				Depend dependtOutput1 = new DependController().updateDepend(updateDepend);
				if(dependtOutput1!= null) {
					System.out.println("Insert operation in Depend:-");
					System.out.println("depend id:"+dependtOutput1.getDependId()
										+"\t"+"depend firstname:"+dependtOutput1.getFirstName()
										+"\t"+"depend lastname:"+dependtOutput1.getLastName()
										+"\t"+"depend relation:"+dependtOutput1.getRelation()
										+"\t"+"empid:"+dependtOutput1.getEmpId());	
				}
				else
				{
					System.out.println("Depend already exists in the database");
				}	
	
				System.out.println("=================================");
				System.out.println("Delete operation in Depend:");
				String delete=new DependController().delteDepend(7);
				System.out.println(delete);
				
				
	}

}
