package hw.homework11_PostOffice;

import java.util.Objects;

public class Post {
    private String contentName;
    private Address address;


    public Post(String contentName, Address address) {
        this.contentName = contentName;
        this.address = address;
    }

    public String getContentName() {
        return contentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(contentName, post.contentName) &&
                Objects.equals(address, post.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contentName, address);
    }

    @Override
    public String toString() {
        return "Post{" +
                "contentName='" + contentName + '\'' +
                ", address=" + address +
                '}';
    }
}
