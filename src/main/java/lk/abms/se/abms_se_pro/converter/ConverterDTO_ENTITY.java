package lk.abms.se.abms_se_pro.converter;


import lk.abms.se.abms_se_pro.entity.SuperEntity;
import lk.abms.se.abms_se_pro.entity.WorkerCategory;
import lk.abms.se.abms_se_pro.model.SuperDTO;
import lk.abms.se.abms_se_pro.model.WorkerCategoryDTO;

public class ConverterDTO_ENTITY {

    public static <T extends SuperDTO> T getDTO(SuperEntity entity) {
        if (entity instanceof WorkerCategory) {
            WorkerCategory c = (WorkerCategory) entity;
            return (T) new WorkerCategory(c.getEmpCatId(), c.getName(), c.getCreateBy());
        } else {
            throw new RuntimeException("This entity can't be converted to a DTO");
        }
    }

    public static <T extends SuperEntity> T getEntity(SuperDTO dto) {
        if (dto instanceof WorkerCategoryDTO) {
            WorkerCategoryDTO c = (WorkerCategoryDTO) dto;
            return (T) new WorkerCategory(c.getEmpCatId(), c.getName(), c.getCreateBy());
        } else {
            throw new RuntimeException("This DTO can't be converted to an entity");
        }
    }

}
