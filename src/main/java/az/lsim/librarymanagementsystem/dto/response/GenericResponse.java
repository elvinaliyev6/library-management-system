package az.lsim.librarymanagementsystem.dto.response;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class GenericResponse<T> {

    private T data;
    private String status;

}
