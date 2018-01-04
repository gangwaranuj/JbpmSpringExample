package com.thinksys.bpm.utility;

import java.util.List;

public class JsonResponse<T> {
	private String Result;
	
	private List<T> Records;
	
    private T Record;
 
    private String Message;
    
    private List<T> Options ;

	private int TotalRecordCount;

	public JsonResponse(){}
 
    
    public JsonResponse(String Result) {
        this.Result = Result;
    }
 
    public JsonResponse(String Result, T Record) {
        this.Result = Result;
        this.Record = Record;
    }
    
    public JsonResponse(String Result, T Record,int TotalRecordCount) {
        this.Result = Result;
        this.Record = Record;
        this.setTotalRecordCount(TotalRecordCount);
    }
 
    public JsonResponse(String Result, String Message) {
        this.Result = Result;
        this.Message = Message;
    }

    public JsonResponse(String Result, List<T> Records,int TotalRecordCount) {
		this.Result = Result;
		this.Records = Records;
		this.setTotalRecordCount(TotalRecordCount);
	}

    public JsonResponse(String Result, List<T> Options) {
		this.Result = Result;
		this.Options = Options;
	}
    
    public List<T> getOptions() {
		return Options;
	}

	public void setOptions(List<T> Options) {
		this.Options = Options;
	}
    public String getResult() {
        return Result;
    }
 
    public void setResult(String Result) {
        this.Result = Result;
    }
 
    public T getRecord() {
        return Record;
    }
 
    public void setRecord(T Record) {
        this.Record = Record;
    }   
 
    public String getMessage() {
        return Message;
    }
 
    public void setMessage(String Message) {
        this.Message = Message;
    }

    public List<T> getRecords() {
		return Records;
	}

	public void setRecords(List<T> Records) {
		this.Records = Records;
	}

	
	public int getTotalRecordCount() {
		return TotalRecordCount;
	}

	public void setTotalRecordCount(int totalRecordCount) {
		TotalRecordCount = totalRecordCount;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JsonResponse "
				+ "[" 
				+ (Result != null ? "Result=" + Result + ", " : "")
				+ (Records != null ? "Records=" + Records + ", " : "")
				+ (Record != null ? "Record=" + Record + ", " : "")
				+ (Message != null ? "Message=" + Message + ", " : "")
				+ (Options != null ? "Options=" + Options + ", " : "") 
				+ "TotalRecordCount=" + TotalRecordCount 
				+ "]";
	}

}