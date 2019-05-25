package br.com.digitalhouse.conversandocomfragments.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Pessoa implements Parcelable {

    private String name;
    private String profession;
    private int age;



    public Pessoa() {
    }

    public Pessoa(String name, String profession, int age) {
        this.name = name;
        this.profession = profession;
        this.age = age;
    }

    protected Pessoa(Parcel in) {
        name = in.readString();
        profession = in.readString();
        age = in.readInt();
    }

    public static final Creator<Pessoa> CREATOR = new Creator<Pessoa>() {
        @Override
        public Pessoa createFromParcel(Parcel in) {
            return new Pessoa(in);
        }

        @Override
        public Pessoa[] newArray(int size) {
            return new Pessoa[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(profession);
        parcel.writeInt(age);
    }
}
