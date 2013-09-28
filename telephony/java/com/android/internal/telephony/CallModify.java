package com.android.internal.telephony;

	public class CallModify
	{
	  public CallDetails call_details = new CallDetails();
	  public int call_index = 0;

	  public void setCallDetails(CallDetails paramCallDetails)
	  {
	    this.call_details = new CallDetails(paramCallDetails);
	  }

	  public String toString()
	  {
	    return " " + this.call_index + " " + this.call_details;
	  }
	}
