package java14.record;

import java.util.Objects;

public record PhoneNumber(Integer lineNumber, Integer prefix, Integer areaCode) {
	
	public static String UNKNOWN_ADDRESS = "Unknown";
	
	public PhoneNumber {
        Objects.requireNonNull(lineNumber);
    }
    
    /*public PhoneNumber(Integer lineNumber, Integer prefix, Integer areaCode) {
        this.lineNumber = lineNumber;
        this.prefix = prefix;
        this.areaCode = areaCode;
    }
	
    public PhoneNumber(Integer lineNumber) {
        this(lineNumber, null, null);
    }*/
    
    public static PhoneNumber unnamed(Integer lineNumber) {
        return new PhoneNumber(lineNumber, null, null);
    }
}

/*public class PhoneNumber {

    private Integer lineNumber;
    private Integer prefix;
    private Integer areaCode;

    public Integer getLineNumber() {
        return lineNumber;
    }

    public Integer getPrefix() {
        return prefix;
    }

    public Integer getAreaCode() {
        return areaCode;
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;

        PhoneNumber that = (PhoneNumber) o;
        return super.equals(that)
            && Objects.equals(this.lineNumber, that.lineNumber)
            && Objects.equals(this.prefix, that.prefix)
            && Objects.equals(this.areaCode, that.areaCode);
    }
}*/