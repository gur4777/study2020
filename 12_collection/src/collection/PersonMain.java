package collection;

import java.util.ArrayList;
import java.util.Iterator;

public class PersonMain {
	
	
	public ArrayList<PersonDTO> init() {
		
		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>();
		
		PersonDTO aa = new PersonDTO("ȫ�浿", 25);
		PersonDTO bb = new PersonDTO("��ġ", 40);
		PersonDTO cc = new PersonDTO("�ڳ�", 16);
		
		list.add(aa);
		list.add(bb);
		list.add(cc);
		
		return list;
		
	}
	public static void main(String[] args) {
		PersonMain pm = new PersonMain();
		ArrayList<PersonDTO> list = pm.init();
		
//		for(int i=0; i<list.size(); i++) {
//			System.out.println("�̸� = "+list.get(i).getName()+" \t ���� = "+list.get(i).getAge());
//		}
//		System.out.println("----------------");
		for(PersonDTO dto : list) {
			//System.out.println(dto.getName()+"\t"+ dto.getAge());
			System.out.println(dto);
		}
		System.out.println("----------------");
		
//		Iterator<PersonDTO> it = list.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
		}

	}

//}