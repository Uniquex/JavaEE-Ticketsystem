package pw.vhome.ticketsystem.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vitz on 09.06.17.
 */
@Entity
public class Inquiry {

    @GeneratedValue
    @Id
    private long id;

    private Kind kind;
    private Date timeIssued;
    private Date timeInProcess;
    private Date timeFinished;
    private Status status;

    @OneToOne
    private User Agent;

    @OneToOne
    private User Customer;

    private Priority priority;
    private String message;

    public Kind getKind() {
        return kind;
    }

    public void setTicket(Kind kind) {
        this.kind = kind;
    }

    public String getTimeIssued() {
        return timeIssued.toString();
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public enum Status
    {
        Open, Pending, Resolved, Closed
    }
    public enum Kind
    {
        Incident, ServiceRequest
    }
    public enum Priority
    {
        critical, high, medium, low
    }
}