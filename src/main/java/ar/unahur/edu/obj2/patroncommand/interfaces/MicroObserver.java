package ar.unahur.edu.obj2.patroncommand.interfaces;

import ar.unahur.edu.obj2.patroncommand.micro.Programable;

public interface MicroObserver {
    void onStateChanged(Programable micro);
    void onError(String message);
}