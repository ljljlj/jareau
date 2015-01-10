package net.yorkjr.jareau.pojo;

import java.util.Date;

/**
 * Created by tylaar on 15/1/10.
 */
public class CompanyAgent {
    private String companyName;
    private long companyId;
    private long agentId;
    private String agentName;
    private String address;
    private String telephone;
    private Date creationDate;
    private Date lastUpdate;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(final String companyName) {
        this.companyName = companyName;
    }

    public long getAgentId() {
        return agentId;
    }

    public void setAgentId(final long agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(final String agentName) {
        this.agentName = agentName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(final String telephone) {
        this.telephone = telephone;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(final long companyId) {
        this.companyId = companyId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(final Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(final Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
