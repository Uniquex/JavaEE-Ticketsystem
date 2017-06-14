package pw.vhome.ticketsystem.model;

import java.util.Date;

/**
 * Created by vitz on 09.06.17.
 */
public class Inquiry {
    private long id;
    private Ticket ticket;
    private Date timeIssued;
    private Date timeInProcess;
    private Date timeFinished;
    private Status status;
    private User Agent;
    private User Customer;
    private Priority priority;

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

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public enum Status
    {
        Open, Pending, Resolved, Closed;
    }
    public enum Ticket
    {
        Incident, ServiceRequest;
    }
    public enum Priority
    {
        critical, high, medium, low;
    }
}