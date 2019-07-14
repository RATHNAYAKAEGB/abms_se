package lk.abms.se.abms_se_pro.converter;


import lk.abms.se.abms_se_pro.entity.*;
import lk.abms.se.abms_se_pro.model.*;

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
        }else if (entity instanceof Worker){
            Worker c = (Worker) entity;
            String wy =(c.getWc_Id().isACtive())? "Managerial" :"Non Managirial";
            return (T) new WorkerDTO(c.getWorkerId(),c.getNic(),c.getFirstName(),c.getFullName(),c.getAddress(),c.getImg(),c.getMobile(),c.getWc_Id().getCatId(),c.getWc_Id().getCat_Name(),wy,c.getRegDate());
        }else if (entity instanceof Site){
            Site c = (Site) entity;
            String isActive =(c.isActive())? "IsActive" :"InActive";
            return (T) new SiteDTO(c.getSiteId(),c.getRegDate(),c.getSitName(),c.getAddress(),isActive,c.getWorkerID().getWorkerId(),c.getWorkerID().getFullName(),c.getWorkerID().getMobile());
        }else if (entity instanceof Attendence){
            Attendence c = (Attendence) entity;
            return (T) new AttendenceDTO(c.getSiteId().getSiteId(),c.getSiteId().getSitName(),c.getSiteId().getWorkerID().getFullName(),c.getWorkerId().getWorkerId(),c.getWorkerId().getNic(),c.getWorkerId().getFullName(),DateForMatter.getLocalDate(c.getaDate()),c.getInTime(),c.getOutTime(),c.isPaid(),c.getAdvanceAmount(),c.getNofHours());
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

        }else if(dto instanceof WorkerDTO){
            WorkerDTO c = (WorkerDTO) dto;
            return (T) new Worker(c.getWorkerId(),c.getNic(),c.getFirstName(),c.getFullName(),c.getAddress(),c.getImg(),c.getMobile(),null,c.getRegDate());

        }else if(dto instanceof SiteDTO){
            SiteDTO c = (SiteDTO) dto;
            boolean isActive =(c.getIsActive().equals("IsActive"))? true:false;
            return (T) new Site(c.getSiteId(),c.getRegDate(),c.getSitName(),c.getAddress(),isActive,null);
        }else if(dto instanceof AttendenceDTO){
            AttendenceDTO c = (AttendenceDTO) dto;
            return (T) new Attendence(DateForMatter.getFortmatteredDate(c.getAtDate()),c.getInTime(),c.getOutTime(),c.getNofHours(),c.isPaid(),c.getAdvanceAmount(),null,null);
        } else {
            throw new RuntimeException("This DTO can't be converted to an entity");
        }
    }


    public static <T extends SuperDTO> List<T> getDTOList(List<? extends SuperEntity> entities) {
        if(null==entities){return null;}
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
