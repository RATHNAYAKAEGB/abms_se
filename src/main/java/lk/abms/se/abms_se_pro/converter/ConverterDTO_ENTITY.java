package lk.abms.se.abms_se_pro.converter;


import lk.abms.se.abms_se_pro.entity.PaymentVariable;
import lk.abms.se.abms_se_pro.entity.SuperEntity;
import lk.abms.se.abms_se_pro.entity.WorkerCategory;
import lk.abms.se.abms_se_pro.model.PaymentVariableDTO;
import lk.abms.se.abms_se_pro.model.SuperDTO;
import lk.abms.se.abms_se_pro.model.WorkerCategoryDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ConverterDTO_ENTITY {

    public static <T extends SuperDTO> T getDTO(SuperEntity entity) {
        if (entity instanceof WorkerCategory) {
            WorkerCategory c = (WorkerCategory) entity;
            return (T) new WorkerCategoryDTO(c.getCatId(), c.getCat_Name(), c.getSalaryType(),c.getDescription(),c.isACtive(),c.getCreatedBy());
        }else if (entity instanceof PaymentVariable){
            PaymentVariable c = (PaymentVariable) entity;
            return (T) new PaymentVariableDTO(c.getSvID(), c.getName(), c.getNomalRate(),c.getOtReate(),c.getBonuseReate(),c.getDescription(),c.getCategoryId().getCatId(),c.getCategoryId().getCat_Name());

        }

        else {
            throw new RuntimeException("This entity can't be converted to a DTO");
        }
    }

    public static <T extends SuperEntity> T getEntity(SuperDTO dto) {
        if (dto instanceof WorkerCategoryDTO) {
            WorkerCategoryDTO c = (WorkerCategoryDTO) dto;
            return (T) new WorkerCategory(c.getCat_Id(), c.getCat_Name(), c.getSalaryType(),c.getDescription(),c.isACtive(),c.getCreatedBy());
        }else if(dto instanceof PaymentVariableDTO){
            PaymentVariableDTO c = (PaymentVariableDTO) dto;
            return (T) new PaymentVariable(c.getSvID(), c.getName(), c.getNomalRate(),c.getOtReate(),c.getBonuseReate(),c.getDescription(),null);

        }

        else {
            throw new RuntimeException("This DTO can't be converted to an entity");
        }
    }


    public static <T extends SuperDTO> List<T> getDTOList(List<? extends SuperEntity> entities) {
        return entities.stream().map(ConverterDTO_ENTITY::<T>getDTO).collect(Collectors.toList());
    }

    public static <T extends SuperEntity> List<T> getEntityList(List<? extends SuperDTO> dtos) {
        return dtos.stream().map(ConverterDTO_ENTITY::<T>getEntity).collect(Collectors.toList());

    }


//    public static List<PaymentVariableDTO> getListPaymentVariableDTO(List<PaymentVariable> list){
//        List<PaymentVariableDTO> dtos = new ArrayList<>();
//        for (PaymentVariable c: list) {
//            dtos.add( new PaymentVariableDTO(c.getSvID(), c.getName(), c.getNomalRate(),c.getOtReate(),c.getBonuseReate(),c.getDescription(),c.getCategoryId().getCatId(),c.getCategoryId().getCat_Name()));
//
//        }
//        return dtos;
//    }



}
