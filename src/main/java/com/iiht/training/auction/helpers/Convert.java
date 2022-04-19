//  package com.iiht.training.auction.helpers;
//  import com.iiht.training.auction.dto.CustomerDto;
//  import com.iiht.training.auction.dto.ProductDto;
//  import com.iiht.training.auction.dto.BidsDto;
//  import com.iiht.training.auction.dto.SellerDto;
//  import com.iiht.training.auction.entity.CustomerEntity;
//  import com.iiht.training.auction.entity.BidsEntity;
//  import com.iiht.training.auction.entity.ProductEntity;
//  import com.iiht.training.auction.entity.SellerEntity;


//  public class Convert<T>{

//     @override
//     public static T DTOtoEntity(T Dto){
//             T Entity = new T();
//             Entity.setAddress(Dto.getAddress());
//             Entity.setEmail(Dto.getEmail());
//             Entity.setPassword(Dto.getPassword());
//             Entity.setPhoneNumber(Dto.getPhoneNumber());
//             Entity.setUsername(Dto.getUsername());
//             return Entity;
//         }
//     @override
//     public static T EntitytoDTO(T Entity){ 
//         T dto=new T();
//         dto.setAddress(Entity.getAddress());
//         dto.setEmail(Entity.getEmail());
//         dto.setPassword(Entity.getPassword());
//         dto.setPhoneNumber(Entity.getPhoneNumber());
//         dto.setUsername(Entity.getUsername());
//         return dto;
//     }

//  }