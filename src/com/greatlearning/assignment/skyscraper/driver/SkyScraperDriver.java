package com.greatlearning.assignment.skyscraper.driver;

import java.util.Scanner;
import java.util.Stack;
/*
 * Logic -  1. Get input with all validations from user and store it in floor[]. 
 * 			2. Create two stacks - stack and tempStack. 
 * 			3. The tempStack is used as temporary container to sort the elements in the original stack 
 * 			   while inserting element into it one by one from input floor[] (top of stack to bottom of stack is ordered in decreasing order).
 * 			4.  
 * 			3. While top of stack is equal to current element of floor[] then pop the element from the stack and decrease current element by 1 to 
 * 			   check next smaller floor.
 *        	   
 *        	3. If 
 */
public class SkyScraperDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=0;
		while(true) {
			System.out.println("Enter the total number of floors in the building");
			int t1 = sc.nextInt();
			if(t1>0) {
				n=t1;
				break;
			}
		}
		int day =1;
		int[] floor = new int[n];
		for(int i=0;i<n;) {
			System.out.println("enter the floor size given on day "+day);
			int temp = sc.nextInt();
			boolean duplicate=false;
			for(int j=0;j<i;j++) {
				if(temp == floor[j]) {
					System.out.println("floor# "+temp+" is already constructed!");
					duplicate = true;
					break;
				}
			}
			if(duplicate == false) {
				if(temp <= n && temp > 0) {
					floor[i] = temp;
					i++;
					day++;
				} else 
					System.out.println("Please enter valid floor size > 0 < "+n);
			}
		}
		day = 1;
		int res = n;
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> tmpStack = new Stack<>();
		for(int j=0;j<n;j++) {
			System.out.println("Day: "+day++);
			if(stack.isEmpty())
				stack.push(floor[j]);
			else {
				if(floor[j] > stack.peek())
					stack.push(floor[j]);
				else {
					while(!stack.isEmpty() && stack.peek() > floor[j])
						tmpStack.push(stack.pop());
					stack.push(floor[j]);
					while(!tmpStack.isEmpty())
						stack.push(tmpStack.pop());
				}
			}
			while(!stack.isEmpty() && stack.peek() == res) {
				System.out.print(stack.pop()+" ");
				res--;
			}
		}
	}
}