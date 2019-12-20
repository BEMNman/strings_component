package com.epam.strings.text.copier;

import com.epam.strings.text.exception.NotCopyObjectException;

import java.io.*;

public class Copier<T> {

    public T copy(T original) throws NotCopyObjectException {

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(original);
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream in = new ObjectInputStream(bis);
            return (T) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new NotCopyObjectException(e);
        }




    }
}
