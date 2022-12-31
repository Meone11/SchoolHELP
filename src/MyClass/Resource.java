/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyClass;

import java.io.Serializable;

/**
 *
 * @author meone
 */
public class Resource extends Request implements Serializable{
    
    private String SchoolName, resourceType, numRequired;

    public Resource(String SchoolName, String resourceType, String numRequired, String requestID, String requestDate, String requestStatus, String description) {
        super(requestID, requestDate, requestStatus, description);
        this.SchoolName = SchoolName;
        this.resourceType = resourceType;
        this.numRequired = numRequired;
    }

    public String getSchoolName() {
        return SchoolName;
    }

    public void setSchoolName(String SchoolName) {
        this.SchoolName = SchoolName;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getNumRequired() {
        return numRequired;
    }

    public void setNumRequired(String numRequired) {
        this.numRequired = numRequired;
    }
}
