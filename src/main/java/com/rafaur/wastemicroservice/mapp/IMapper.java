package com.rafaur.wastemicroservice.mapp;

public interface IMapper <I, O> {
    public O mapItoO(I in);
    public I mapOtoI(O in);
}
