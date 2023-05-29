package sit.thinktaegeb.mybackend.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class PageDTO<T> {
    private List<T> content;
    private Boolean last;
    private Boolean first;
    private Integer totalPages;
    private Integer totalElements;
    private Integer size;
    @JsonIgnore
    private Integer number;

    public Integer getPage() {
        return this.number;
    }

    public List<T> getContent() {
        return this.content;
    }

    public Boolean getLast() {
        return this.last;
    }

    public Boolean getFirst() {
        return this.first;
    }

    public Integer getTotalPages() {
        return this.totalPages;
    }

    public Integer getTotalElements() {
        return this.totalElements;
    }

    public Integer getSize() {
        return this.size;
    }

    public Integer getNumber() {
        return this.number;
    }

    public void setContent(final List<T> content) {
        this.content = content;
    }

    public void setLast(final Boolean last) {
        this.last = last;
    }

    public void setFirst(final Boolean first) {
        this.first = first;
    }

    public void setTotalPages(final Integer totalPages) {
        this.totalPages = totalPages;
    }

    public void setTotalElements(final Integer totalElements) {
        this.totalElements = totalElements;
    }

    public void setSize(final Integer size) {
        this.size = size;
    }

    @JsonIgnore
    public void setNumber(final Integer number) {
        this.number = number;
    }

    public PageDTO() {
    }

    public PageDTO(final List<T> content, final Boolean last, final Boolean first, final Integer totalPages, final Integer totalElements, final Integer size, final Integer number) {
        this.content = content;
        this.last = last;
        this.first = first;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.size = size;
        this.number = number;
    }
}