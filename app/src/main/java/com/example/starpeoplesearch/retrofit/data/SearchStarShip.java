
package com.example.starpeoplesearch.retrofit.data;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchStarShip {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("next")
    @Expose
    private Object next;
    @SerializedName("previous")
    @Expose
    private Object previous;
    @SerializedName("results")
    @Expose
    private List<StarShip> results;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Object getNext() {
        return next;
    }

    public void setNext(Object next) {
        this.next = next;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public List<StarShip> getResults() {
        return results;
    }

    public void setResults(List<StarShip> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SearchStarShip.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("count");
        sb.append('=');
        sb.append(((this.count == null)?"<null>":this.count));
        sb.append(',');
        sb.append("next");
        sb.append('=');
        sb.append(((this.next == null)?"<null>":this.next));
        sb.append(',');
        sb.append("previous");
        sb.append('=');
        sb.append(((this.previous == null)?"<null>":this.previous));
        sb.append(',');
        sb.append("results");
        sb.append('=');
        sb.append(((this.results == null)?"<null>":this.results));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.count == null)? 0 :this.count.hashCode()));
        result = ((result* 31)+((this.next == null)? 0 :this.next.hashCode()));
        result = ((result* 31)+((this.previous == null)? 0 :this.previous.hashCode()));
        result = ((result* 31)+((this.results == null)? 0 :this.results.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SearchStarShip) == false) {
            return false;
        }
        SearchStarShip rhs = ((SearchStarShip) other);
        return (((((this.count == rhs.count)||((this.count!= null)&&this.count.equals(rhs.count)))&&((this.next == rhs.next)||((this.next!= null)&&this.next.equals(rhs.next))))&&((this.previous == rhs.previous)||((this.previous!= null)&&this.previous.equals(rhs.previous))))&&((this.results == rhs.results)||((this.results!= null)&&this.results.equals(rhs.results))));
    }

}
