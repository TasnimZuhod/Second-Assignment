package com.example.calculator;

import java.util.LinkedList;
import java.util.Queue;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/*
 * Tasnim Zuhod
 * 1111313
 */

public class MainActivity extends ActionBarActivity {

	EditText edtxt;
	Queue<String> queue = new LinkedList<String>();
	double m = 0;
	String cache = "";
	boolean flag = false;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        edtxt = (EditText) findViewById(R.id.txt);
        
        Button cbtn = (Button) findViewById(R.id.cbtn);
        Button backbtn = (Button) findViewById(R.id.backbtn);
        Button mbtn = (Button) findViewById(R.id.mbtn);
        Button mcbtn = (Button) findViewById(R.id.mcbtn);
        Button mrbtn = (Button) findViewById(R.id.mrbtn);
        Button nbtn = (Button) findViewById(R.id.nbtn);
        
        Button addbtn = (Button) findViewById(R.id.addbtn);
        Button subbtn = (Button) findViewById(R.id.subbtn);
        Button mulbtn = (Button) findViewById(R.id.mulbtn);
        Button divbtn = (Button) findViewById(R.id.divbtn);
        Button equalbtn = (Button) findViewById(R.id.equalbtn);
        
        Button zerobtn = (Button) findViewById(R.id.zerobtn);
        Button onebtn = (Button) findViewById(R.id.onebtn);
        Button twobtn = (Button) findViewById(R.id.twobtn);
        Button threebtn = (Button) findViewById(R.id.threebtn);
        Button fourbtn = (Button) findViewById(R.id.fourbtn);
        Button fivebtn = (Button) findViewById(R.id.fivebtn);
        Button sixbtn = (Button) findViewById(R.id.sixbtn);
        Button sevenbtn = (Button) findViewById(R.id.sevenbtn);
        Button eightbtn = (Button) findViewById(R.id.eightbtn);
        Button ninebtn = (Button) findViewById(R.id.ninebtn);
        
        
        cbtn.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		edtxt.setText("");
        		queue.clear();
        		flag = false;
        	}
        });
        
        
        backbtn.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		back();
        	}
        });
        
        
        mbtn.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		String text;
        		if(flag){//if there is resulted value before
        			text = cache;
        			m += Double.parseDouble(text);
        		}
        		else{
        			text = edtxt.getText().toString();
        			if(text.equals(""))
            			m += 0;
        			else
            			m += Double.parseDouble(text);
        		}
        		edtxt.setText("");
        	}
        });
        
        
        mcbtn.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		m = 0;
        	}
        });
        
        
        mrbtn.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		String text = edtxt.getText().toString();
        		edtxt.setText(text+m);
        	}
        });
        
        
        nbtn.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		String text;
        		if(flag)//if there is resulted value before
        			text = cache;
        		else
        			text = edtxt.getText().toString();
        		edtxt.setText("-"+text);
        	}
        });
        
        
        addbtn.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		String text;
        		if(flag)//if there is resulted value before
        			text = cache;
        		else{
        			text = edtxt.getText().toString();
        			String [] nb = text.split("[- + × ÷]");
            		queue.add( nb[nb.length-1] );
        		}
        		edtxt.setText(text+"+");
        		queue.add("+");
        	}
        });
        
        
        subbtn.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		String text;
        		if(flag)//if there is resulted value before
        			text = cache;
        		else{
        			text = edtxt.getText().toString();
        			String [] nb = text.split("[- + × ÷]");
            		queue.add( nb[nb.length-1] );
        		}
        		edtxt.setText(text+"-");
        		queue.add("-");
        	}
        });
        
        
        mulbtn.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		String text;
        		if(flag)//if there is resulted value before
        			text = cache;
        		else{
        			text = edtxt.getText().toString();
        			String [] nb = text.split("[- + × ÷]");
            		queue.add( nb[nb.length-1] );
        		}
        		edtxt.setText(text+"×");
        		queue.add("×");
        	}
        });
        
        
        divbtn.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		String text;
        		if(flag)//if there is resulted value before
        			text = cache;
        		else{
        			text = edtxt.getText().toString();
        			String [] nb = text.split("[- + × ÷]");
            		queue.add( nb[nb.length-1] );
        		}
        		edtxt.setText(text+"÷");
        		queue.add("÷");
        	}
        });
        
        
        equalbtn.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		String text = edtxt.getText().toString();
        		if( queue.isEmpty() ){
        			if( !text.equals("") ){//one number is entered
        				queue.add( text );
        			}
        		}
        		else if(queue.size() >= 2){
        			String [] nb = text.split("[- + × ÷]");
        			if( nb.length > 1 )//there is more than one number
        				queue.add( nb[nb.length-1] );
        		}
        		getResult();
        	}
        });
        
        
        zerobtn.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		String text = edtxt.getText().toString();
        		edtxt.setText(text+"0");
        	}
        });
        
        
        onebtn.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		String text = edtxt.getText().toString();
        		edtxt.setText(text+"1");
        	}
        });
        
        
        twobtn.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		String text = edtxt.getText().toString();
        		edtxt.setText(text+"2");
        	}
        });
        
        
        threebtn.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		String text = edtxt.getText().toString();
        		edtxt.setText(text+"3");
        	}
        });
        
        
        fourbtn.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		String text = edtxt.getText().toString();
        		edtxt.setText(text+"4");
        	}
        });
        
        
        fivebtn.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		String text = edtxt.getText().toString();
        		edtxt.setText(text+"5");
        	}
        });
        
        
        sixbtn.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		String text = edtxt.getText().toString();
        		edtxt.setText(text+"6");
        	}
        });
        
        
        sevenbtn.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		String text = edtxt.getText().toString();
        		edtxt.setText(text+"7");
        	}
        });
        
        
        eightbtn.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		String text = edtxt.getText().toString();
        		edtxt.setText(text+"8");
        	}
        });
        
        
        ninebtn.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		String text = edtxt.getText().toString();
        		edtxt.setText(text+"9"); 
        	}
        });
        
        
    }
    
    
    public void getResult(){
    	
		if(queue.isEmpty()){//if enter = before enter any number
			print("There is no value to calculate !");
			return;
		}
		else if(queue.size() == 1){//if enter = after entering one number --> display it
			edtxt.setText("");
			edtxt.setText(queue.poll());
			return;
		}
		else if(queue.size() == 2){//if enter = after entering one number and operator
			print("Wrong Format");
			return;
		}
		
		double value=0;
		int counter=0;
		while( !queue.isEmpty() ){
			String oprnd1="", oprnd2="", oprtr="";
			if(counter == 0){//at first time, poll two operands
				oprnd1 = queue.poll();
				oprtr = queue.poll();
				oprnd2 = queue.poll();
				value = calculate(Double.parseDouble(oprnd1), Double.parseDouble(oprnd2), oprtr.charAt(0));
				counter++;
			}
			else{//then, poll one operand and send it with the value to calculate function
				oprtr = queue.poll();
				oprnd2 = queue.poll();
				value = calculate(value, Double.parseDouble(oprnd2), oprtr.charAt(0));
			}
		}
		
		String text = edtxt.getText().toString();
		String result = String.valueOf( value );
		edtxt.setText(text+"=\n"+result);
		flag = true;
		cache = result;
		queue.add(cache);//for later use
		
    }
    
    
    public double calculate(double operand1, double operand2, char operator){
    	
    	double result = 0;
    	switch(operator){
    	case '+':
    		result = operand1 + operand2;
    		break;
    	case '-':
    		result = operand1 - operand2;
    		break;
    	case '×':
    		result = operand1 * operand2;
    		break;
    	case '÷':
    		result = operand1 / operand2;
    		break;
    	}
    	
    	return result;
    }
    
    
    public void back(){
    	
    	String equation = "";
    	int size = queue.size();
    	for(int i=0; i<size; i++)
    		equation += queue.poll();
    	queue.clear();
    	
    	String oprnd = "";
    	//Again, add the equation into Queue without last number
    	for(int i=0; i<equation.length(); i++){
    		if( Character.isDigit( equation.charAt(i)) )
    			oprnd += String.valueOf( equation.charAt(i) );
    		else{
    			queue.add(oprnd);//add number
    			oprnd = "";
    			queue.add(String.valueOf( equation.charAt(i) ));//add operator
    		}
    	}
    	edtxt.setText(equation);
    }
    
    
    public void print(String msg){
    	Toast.makeText(getBaseContext(), msg ,Toast.LENGTH_LONG).show();
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
