package com.webtools.finalProject.pojo;

import java.io.Serializable;

public class AirplanePK implements Serializable{
	
	private String modelNumber;
	private Airliner airliner;
	
	public AirplanePK(String modelNumber,Airliner airliner) {
		this.modelNumber = modelNumber;
		this.airliner = airliner;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public Airliner getAirliner() {
		return airliner;
	}

	public void setAirliner(Airliner airliner) {
		this.airliner = airliner;
	}
	
    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + (modelNumber == null ? 0 : modelNumber.hashCode());
        result = PRIME * result + (airliner == null ? 0 : airliner.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(!(obj instanceof AirplanePK)) return false;
        AirplanePK objKey = (AirplanePK)obj;
        if(modelNumber.equalsIgnoreCase(objKey.modelNumber) &&
        		airliner.equals(objKey.airliner)) {
            return true;
        }
        return false;
    }
}
