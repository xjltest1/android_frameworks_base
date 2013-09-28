package com.android.internal.telephony;

public class CallDetails
{
  public static final int RIL_CALL_DOMAIN_AUTOMATIC = 3;
  public static final int RIL_CALL_DOMAIN_CS = 1;
  public static final int RIL_CALL_DOMAIN_NOT_SET = 4;
  public static final int RIL_CALL_DOMAIN_PS = 2;
  public static final int RIL_CALL_DOMAIN_UNKNOWN = 0;
  public static final int RIL_CALL_TYPE_VOICE = 0;
  public static final int RIL_CALL_TYPE_VS_RX = 2;
  public static final int RIL_CALL_TYPE_VS_TX = 1;
  public static final int RIL_CALL_TYPE_VT = 3;
  public int call_domain;
  public int call_type;
  public String[] extras;

  public CallDetails()
  {
    this.call_type = 0;
    this.call_domain = 4;
    this.extras = null;
  }

  public CallDetails(int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    this.call_type = paramInt1;
    this.call_domain = paramInt2;
    this.extras = paramArrayOfString;
  }

  public CallDetails(CallDetails paramCallDetails)
  {
    this.call_type = paramCallDetails.call_type;
    this.call_domain = paramCallDetails.call_domain;
    this.extras = paramCallDetails.extras;
  }

  public void setExtras(String[] paramArrayOfString)
  {
    this.extras = paramArrayOfString;
  }

  public String toString()
  {
    return " " + this.call_type + " " + this.call_domain + " " + this.extras;
  }
}
