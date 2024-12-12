<<<<<<< HEAD
package mk.ukim.finki.wp.lab.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidAlbumIdException extends RuntimeException{
    public InvalidAlbumIdException(Long albumId){
        super(String.format("Album with id: %d was not found", albumId));


    }
}
=======
package mk.ukim.finki.wp.lab.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidAlbumIdException extends RuntimeException{
    public InvalidAlbumIdException(Long albumId){
        super(String.format("Album with id: %d was not found", albumId));


    }
}
>>>>>>> 7c6648558d2896e91b6d75476646ca49db013d34
