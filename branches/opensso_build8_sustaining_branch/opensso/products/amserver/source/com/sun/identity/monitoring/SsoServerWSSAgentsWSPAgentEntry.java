package com.sun.identity.monitoring;

//
// Generated by mibgen version 5.1 (05/20/05) when compiling SUN-OPENSSO-SERVER-MIB.
//

// java imports
//
import java.io.Serializable;

// jmx imports
//
import com.sun.management.snmp.SnmpStatusException;

// jdmk imports
//
import com.sun.management.snmp.agent.SnmpMib;

/**
 * The class is used for implementing the "SsoServerWSSAgentsWSPAgentEntry" group.
 * The group is defined with the following oid: 1.3.6.1.4.1.42.2.230.3.1.1.2.1.22.3.1.
 */
public class SsoServerWSSAgentsWSPAgentEntry implements SsoServerWSSAgentsWSPAgentEntryMBean, Serializable {

    /**
     * Variable for storing the value of "WssAgentsWSPAgentSvcEndPoint".
     * The variable is identified by: "1.3.6.1.4.1.42.2.230.3.1.1.2.1.22.3.1.4".
     */
    protected String WssAgentsWSPAgentSvcEndPoint = new String("JDMK 5.1");

    /**
     * Variable for storing the value of "WssAgentsWSPAgentProxy".
     * The variable is identified by: "1.3.6.1.4.1.42.2.230.3.1.1.2.1.22.3.1.3".
     */
    protected String WssAgentsWSPAgentProxy = new String("JDMK 5.1");

    /**
     * Variable for storing the value of "WssAgentsWSPAgentName".
     * The variable is identified by: "1.3.6.1.4.1.42.2.230.3.1.1.2.1.22.3.1.2".
     */
    protected String WssAgentsWSPAgentName = new String("JDMK 5.1");

    /**
     * Variable for storing the value of "WssAgentsWSPAgentIndex".
     * The variable is identified by: "1.3.6.1.4.1.42.2.230.3.1.1.2.1.22.3.1.1".
     */
    protected Integer WssAgentsWSPAgentIndex = new Integer(1);

    /**
     * Variable for storing the value of "SsoServerRealmIndex".
     * The variable is identified by: "1.3.6.1.4.1.42.2.230.3.1.1.2.1.9.1.1".
     */
    protected Integer SsoServerRealmIndex = new Integer(1);


    /**
     * Constructor for the "SsoServerWSSAgentsWSPAgentEntry" group.
     */
    public SsoServerWSSAgentsWSPAgentEntry(SnmpMib myMib) {
    }

    /**
     * Getter for the "WssAgentsWSPAgentSvcEndPoint" variable.
     */
    public String getWssAgentsWSPAgentSvcEndPoint() throws SnmpStatusException {
        return WssAgentsWSPAgentSvcEndPoint;
    }

    /**
     * Getter for the "WssAgentsWSPAgentProxy" variable.
     */
    public String getWssAgentsWSPAgentProxy() throws SnmpStatusException {
        return WssAgentsWSPAgentProxy;
    }

    /**
     * Getter for the "WssAgentsWSPAgentName" variable.
     */
    public String getWssAgentsWSPAgentName() throws SnmpStatusException {
        return WssAgentsWSPAgentName;
    }

    /**
     * Getter for the "WssAgentsWSPAgentIndex" variable.
     */
    public Integer getWssAgentsWSPAgentIndex() throws SnmpStatusException {
        return WssAgentsWSPAgentIndex;
    }

    /**
     * Getter for the "SsoServerRealmIndex" variable.
     */
    public Integer getSsoServerRealmIndex() throws SnmpStatusException {
        return SsoServerRealmIndex;
    }

}
