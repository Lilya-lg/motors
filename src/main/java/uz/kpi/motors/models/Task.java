package uz.kpi.motors.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnTransformer;

import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.Type;

import org.hibernate.dialect.PostgreSQLEnumJdbcType;
import uz.kpi.motors.enums.CalcType;

@Entity
@Table(name = "Task")
public class Task {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;
    @Column(name = "weight", nullable = false)
    @Min(value = 1 , message = "Value should be greater then 1")
    @Max(value = 100 , message = "Value should be less then equal to 100")
    @NotNull
    private int weight;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "calctype")
    @JdbcType(PostgreSQLEnumJdbcType.class)
    public CalcType calctype;
    @ManyToOne
    @JoinColumn(name = "period_id", referencedColumnName = "id")
    private Periods period;
    @ManyToOne
    @JoinColumn(name = "dep_id", referencedColumnName = "id")
    private Department department;
    @ManyToOne
    @JoinColumn(name = "metrics_id", referencedColumnName = "id")
    private Metrics metrics;
    @Column(name = "minweight")
    private float minWeight;
    @Column(name = "maxweight")
    private float maxWeight;
    @Column(name = "targetweight")
    private float targetWeight;
    @Column(name = "result")
    private float result;
    @Column(name = "year")
    private int year;
    @Column(name = "actualweight")
    @Min(value = 0, message = "Value should be greater then 0")
    @Max(value = 100 , message = "Value should be less then equal to 100")
    private float actualWeight;
    @Transient
    private int maxW;
    public Task(String name, Person person, int weight, CalcType calctype, Periods period, float minWeight, float maxWeight, float targetWeight, int year,Metrics metrics,Department department) {
        this.name = name;
        this.person = person;
        this.weight = weight;
        this.calctype = calctype;
        this.period = period;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.targetWeight = targetWeight;
        this.year = year;
        this.metrics = metrics;
        this.department = department;
    }

    public Task() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Metrics getMetrics() {
        return metrics;
    }

    public void setMetrics(Metrics metrics) {
        this.metrics = metrics;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    @Column(name ="calctype")
    @ColumnTransformer(write="?::calctype")
    public CalcType getCalcType() {
        return calctype;
    }

    public void setCalcType(CalcType calcType) {
        this.calctype = calcType;
    }

    public Periods getPeriod() {
        return period;
    }

    public void setPeriod(Periods period) {
        this.period = period;
    }

    public float getMinWeight() {
        return minWeight;
    }



    public void setMinWeight(float minWeight) {
        this.minWeight = minWeight;
    }

    public float getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(float maxWeight) {
        this.maxWeight = maxWeight;
    }

    public float getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(float targetWeight) {
        this.targetWeight = targetWeight;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getActualWeight() {
        return actualWeight;
    }

    public void setActualWeight(float actualWeight) {
        this.actualWeight = actualWeight;
    }

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }

    public CalcType getCalctype() {
        return calctype;
    }

    public void setCalctype(CalcType calctype) {
        this.calctype = calctype;
    }

    public int getMaxW() {
        return maxW;
    }

    public void setMaxW() {
        this.maxW = (int) (this.weight*1.2);
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}

