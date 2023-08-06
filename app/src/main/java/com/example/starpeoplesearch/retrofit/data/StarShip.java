
package com.example.starpeoplesearch.retrofit.data;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StarShip {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("manufacturer")
    @Expose
    private String manufacturer;
    @SerializedName("cost_in_credits")
    @Expose
    private String costInCredits;
    @SerializedName("length")
    @Expose
    private String length;
    @SerializedName("max_atmosphering_speed")
    @Expose
    private String maxAtmospheringSpeed;
    @SerializedName("crew")
    @Expose
    private String crew;
    @SerializedName("passengers")
    @Expose
    private String passengers;
    @SerializedName("cargo_capacity")
    @Expose
    private String cargoCapacity;
    @SerializedName("consumables")
    @Expose
    private String consumables;
    @SerializedName("hyperdrive_rating")
    @Expose
    private String hyperdriveRating;
    @SerializedName("MGLT")
    @Expose
    private String mglt;
    @SerializedName("starship_class")
    @Expose
    private String starshipClass;
    @SerializedName("pilots")
    @Expose
    private List<String> pilots;
    @SerializedName("films")
    @Expose
    private List<String> films;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("edited")
    @Expose
    private String edited;
    @SerializedName("url")
    @Expose
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCostInCredits() {
        return costInCredits;
    }

    public void setCostInCredits(String costInCredits) {
        this.costInCredits = costInCredits;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getMaxAtmospheringSpeed() {
        return maxAtmospheringSpeed;
    }

    public void setMaxAtmospheringSpeed(String maxAtmospheringSpeed) {
        this.maxAtmospheringSpeed = maxAtmospheringSpeed;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public String getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(String cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public String getConsumables() {
        return consumables;
    }

    public void setConsumables(String consumables) {
        this.consumables = consumables;
    }

    public String getHyperdriveRating() {
        return hyperdriveRating;
    }

    public void setHyperdriveRating(String hyperdriveRating) {
        this.hyperdriveRating = hyperdriveRating;
    }

    public String getMglt() {
        return mglt;
    }

    public void setMglt(String mglt) {
        this.mglt = mglt;
    }

    public String getStarshipClass() {
        return starshipClass;
    }

    public void setStarshipClass(String starshipClass) {
        this.starshipClass = starshipClass;
    }

    public List<String> getPilots() {
        return pilots;
    }

    public void setPilots(List<String> pilots) {
        this.pilots = pilots;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StarShip.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("model");
        sb.append('=');
        sb.append(((this.model == null)?"<null>":this.model));
        sb.append(',');
        sb.append("manufacturer");
        sb.append('=');
        sb.append(((this.manufacturer == null)?"<null>":this.manufacturer));
        sb.append(',');
        sb.append("costInCredits");
        sb.append('=');
        sb.append(((this.costInCredits == null)?"<null>":this.costInCredits));
        sb.append(',');
        sb.append("length");
        sb.append('=');
        sb.append(((this.length == null)?"<null>":this.length));
        sb.append(',');
        sb.append("maxAtmospheringSpeed");
        sb.append('=');
        sb.append(((this.maxAtmospheringSpeed == null)?"<null>":this.maxAtmospheringSpeed));
        sb.append(',');
        sb.append("crew");
        sb.append('=');
        sb.append(((this.crew == null)?"<null>":this.crew));
        sb.append(',');
        sb.append("passengers");
        sb.append('=');
        sb.append(((this.passengers == null)?"<null>":this.passengers));
        sb.append(',');
        sb.append("cargoCapacity");
        sb.append('=');
        sb.append(((this.cargoCapacity == null)?"<null>":this.cargoCapacity));
        sb.append(',');
        sb.append("consumables");
        sb.append('=');
        sb.append(((this.consumables == null)?"<null>":this.consumables));
        sb.append(',');
        sb.append("hyperdriveRating");
        sb.append('=');
        sb.append(((this.hyperdriveRating == null)?"<null>":this.hyperdriveRating));
        sb.append(',');
        sb.append("mglt");
        sb.append('=');
        sb.append(((this.mglt == null)?"<null>":this.mglt));
        sb.append(',');
        sb.append("starshipClass");
        sb.append('=');
        sb.append(((this.starshipClass == null)?"<null>":this.starshipClass));
        sb.append(',');
        sb.append("pilots");
        sb.append('=');
        sb.append(((this.pilots == null)?"<null>":this.pilots));
        sb.append(',');
        sb.append("films");
        sb.append('=');
        sb.append(((this.films == null)?"<null>":this.films));
        sb.append(',');
        sb.append("created");
        sb.append('=');
        sb.append(((this.created == null)?"<null>":this.created));
        sb.append(',');
        sb.append("edited");
        sb.append('=');
        sb.append(((this.edited == null)?"<null>":this.edited));
        sb.append(',');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null)?"<null>":this.url));
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
        result = ((result* 31)+((this.films == null)? 0 :this.films.hashCode()));
        result = ((result* 31)+((this.passengers == null)? 0 :this.passengers.hashCode()));
        result = ((result* 31)+((this.pilots == null)? 0 :this.pilots.hashCode()));
        result = ((result* 31)+((this.edited == null)? 0 :this.edited.hashCode()));
        result = ((result* 31)+((this.consumables == null)? 0 :this.consumables.hashCode()));
        result = ((result* 31)+((this.created == null)? 0 :this.created.hashCode()));
        result = ((result* 31)+((this.length == null)? 0 :this.length.hashCode()));
        result = ((result* 31)+((this.costInCredits == null)? 0 :this.costInCredits.hashCode()));
        result = ((result* 31)+((this.cargoCapacity == null)? 0 :this.cargoCapacity.hashCode()));
        result = ((result* 31)+((this.url == null)? 0 :this.url.hashCode()));
        result = ((result* 31)+((this.manufacturer == null)? 0 :this.manufacturer.hashCode()));
        result = ((result* 31)+((this.maxAtmospheringSpeed == null)? 0 :this.maxAtmospheringSpeed.hashCode()));
        result = ((result* 31)+((this.crew == null)? 0 :this.crew.hashCode()));
        result = ((result* 31)+((this.mglt == null)? 0 :this.mglt.hashCode()));
        result = ((result* 31)+((this.starshipClass == null)? 0 :this.starshipClass.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.hyperdriveRating == null)? 0 :this.hyperdriveRating.hashCode()));
        result = ((result* 31)+((this.model == null)? 0 :this.model.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof StarShip) == false) {
            return false;
        }
        StarShip rhs = ((StarShip) other);
        return (((((((((((((((((((this.films == rhs.films)||((this.films!= null)&&this.films.equals(rhs.films)))&&((this.passengers == rhs.passengers)||((this.passengers!= null)&&this.passengers.equals(rhs.passengers))))&&((this.pilots == rhs.pilots)||((this.pilots!= null)&&this.pilots.equals(rhs.pilots))))&&((this.edited == rhs.edited)||((this.edited!= null)&&this.edited.equals(rhs.edited))))&&((this.consumables == rhs.consumables)||((this.consumables!= null)&&this.consumables.equals(rhs.consumables))))&&((this.created == rhs.created)||((this.created!= null)&&this.created.equals(rhs.created))))&&((this.length == rhs.length)||((this.length!= null)&&this.length.equals(rhs.length))))&&((this.costInCredits == rhs.costInCredits)||((this.costInCredits!= null)&&this.costInCredits.equals(rhs.costInCredits))))&&((this.cargoCapacity == rhs.cargoCapacity)||((this.cargoCapacity!= null)&&this.cargoCapacity.equals(rhs.cargoCapacity))))&&((this.url == rhs.url)||((this.url!= null)&&this.url.equals(rhs.url))))&&((this.manufacturer == rhs.manufacturer)||((this.manufacturer!= null)&&this.manufacturer.equals(rhs.manufacturer))))&&((this.maxAtmospheringSpeed == rhs.maxAtmospheringSpeed)||((this.maxAtmospheringSpeed!= null)&&this.maxAtmospheringSpeed.equals(rhs.maxAtmospheringSpeed))))&&((this.crew == rhs.crew)||((this.crew!= null)&&this.crew.equals(rhs.crew))))&&((this.mglt == rhs.mglt)||((this.mglt!= null)&&this.mglt.equals(rhs.mglt))))&&((this.starshipClass == rhs.starshipClass)||((this.starshipClass!= null)&&this.starshipClass.equals(rhs.starshipClass))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.hyperdriveRating == rhs.hyperdriveRating)||((this.hyperdriveRating!= null)&&this.hyperdriveRating.equals(rhs.hyperdriveRating))))&&((this.model == rhs.model)||((this.model!= null)&&this.model.equals(rhs.model))));
    }

}
