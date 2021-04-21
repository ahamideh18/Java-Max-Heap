public class myTest {

	public static void main(String[] args) {
		//===================================Testing constructor 1======================================
		System.out.println("=====================================Testing constructor 1=======================================");
		MaxHeap h1=new MaxHeap(3);
		MaxHeap h2=new MaxHeap(0);
		MaxHeap h3=new MaxHeap(10000);
		MaxHeap h4=new MaxHeap(55);
		
		System.out.println("Max capacity of heap1: "+h1.getCapacity());
		System.out.println("Max capacity of heap2: "+h2.getCapacity());
		System.out.println("Max capacity of heap3: "+h3.getCapacity());
		System.out.println("Max capacity of heap4: "+h4.getCapacity());
		
		
		//===================================Testing constructor 2======================================
		System.out.println("=====================================Testing constructor 2=======================================");
		Integer[] a1= {1,2,3,8,90,45,111}, 
		a2= {-9000,8000,-7000,6000,-5000,4000,-3000,2000,-000,0}, 
		a3= {564,564,564,7003},
		a4= {0,1,2,76,23,0,-12,-12,-13,44};
		MaxHeap h5=new MaxHeap(a1);
		MaxHeap h6=new MaxHeap(a2);
		MaxHeap h7=new MaxHeap(a3);
		MaxHeap h8=new MaxHeap(a4);
		
		System.out.println("Max capacity of heap5: "+h5.getCapacity()+" // Size of heap5: "+h5.getSize());
		System.out.println("h5: "+h5.toString()+"\n");
		System.out.println("Max capacity of heap6: "+h6.getCapacity()+" // Size of heap6: "+h6.getSize());
		System.out.println("h6: "+h6.toString()+"\n");
		System.out.println("Max capacity of heap7: "+h7.getCapacity()+" // Size of heap7: "+h7.getSize());
		System.out.println("h7: "+h7.toString()+"\n");
		System.out.println("Max capacity of heap8: "+h8.getCapacity()+" // Size of heap8: "+h8.getSize());
		System.out.println("h8: "+h8.toString()+"\n");
		
		//======================================Testing insert()========================================
		System.out.println("=====================================Testing insert()=========================================");
		h1.insert(0);h1.insert(5);h1.insert(-3);
		System.out.println("Max capacity of heap1: "+h1.getCapacity()+" // Size of heap1: "+h1.getSize());
		System.out.println("h1: "+h1.toString()+"\n");
		
		h6.insert(-1000000000);h1.insert(82);h6.insert(1);
		System.out.println("Max capacity of heap6: "+h6.getCapacity()+" // Size of heap6: "+h6.getSize());
		System.out.println("h6: "+h6.toString()+"\n");
		
		//======================================Testing heapsort()========================================
		System.out.println("=====================================Testing heapsort()=========================================");
		System.out.print("presort a2: ");
		for(int i=0;i<a2.length;i++) {
			System.out.print(a2[i]+", ");
		}
		System.out.print("\n");
		MaxHeap.heapsort(a2);
		System.out.print("sorted a2: ");
		for(int i=0;i<a2.length;i++) {
			System.out.print(a2[i]+", ");
		}
		System.out.print("\n\n");
	
		System.out.print("presort a4: ");
		for(int i=0;i<a4.length;i++) {
			System.out.print(a4[i]+", ");
		}
		System.out.print("\n");
		MaxHeap.heapsort(a4);
		System.out.print("sorted a4: ");
		for(int i=0;i<a4.length;i++) {
			System.out.print(a4[i]+", ");
		}
		System.out.print("\n");
	}

}
