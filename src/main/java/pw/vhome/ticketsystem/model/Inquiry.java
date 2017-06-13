package pw.vhome.ticketsystem.model;

import java.util.Date;

/**
 * Created by vitz on 09.06.17.
 */
public class Inquiry {
    private Ticket ticket;
    private Date timeIssued;
    private Date timeInProcess;
    private Date timeFinished;
    private Status status;
    private User Agent;
    private User Customer;



    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Date getTimeIssued() {
        return timeIssued;
    }

    public void setTimeIssued(Date timeIssued) {
        this.timeIssued = timeIssued;
    }

    public Date getTimeInProcess() {
        return timeInProcess;
    }

    public void setTimeInProcess(Date timeInProcess) {
        this.timeInProcess = timeInProcess;
    }

    public Date getTimeFinished() {
        return timeFinished;
    }

    public void setTimeFinished(Date timeFinished) {
        this.timeFinished = timeFinished;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getAgent() {
        return Agent;
    }

    public void setAgent(User agent) {
        Agent = agent;
    }

    public User getCustomer() {
        return Customer;
    }

    public void setCustomer(User customer) {
        Customer = customer;
    }

    public enum Status
    {
        Open, Pending, Resolved, Closed;
    }
    public enum Ticket
    {
        Incident, ServiceRequest;
    }



}

