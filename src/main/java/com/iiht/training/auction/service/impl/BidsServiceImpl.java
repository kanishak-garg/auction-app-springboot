package com.iiht.training.auction.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.auction.dto.BidsDto;
import com.iiht.training.auction.repository.BidsRepository;
import com.iiht.training.auction.repository.ProductRepository;
import com.iiht.training.auction.service.BidsService;
import com.iiht.training.auction.entity.BidsEntity;

@Service
public class BidsServiceImpl implements BidsService {

	@Autowired
	private BidsRepository bidsRepository;

	@Autowired
    private ProductRepository productRepository;
    
    public BidsEntity dtoToEntity(BidsDto bidsDto){
        BidsEntity bid = new BidsEntity();
        bid.setBidAmount(bidsDto.getBidAmount());
        bid.setBiddingDate(bidsDto.getBiddingDate());
        bid.setProductId(bidsDto.getProductId());
        bid.setCustomerId(bidsDto.getCustomerId());
        return bid;
    }

    public BidsDto EntityToDto(BidsEntity bidsEntity){ 
        BidsDto bidsdto=new BidsDto();
        bidsdto.setId(bidsEntity.getId());
        bidsdto.setBidAmount(bidsEntity.getBidAmount());
        bidsdto.setBiddingDate(bidsEntity.getBiddingDate());
        bidsdto.setProductId(bidsEntity.getProductId());
        bidsdto.setCustomerId(bidsEntity.getCustomerId());
        return bidsdto;
    }

	@Override
	public BidsDto placeBid(BidsDto bidsDto) {
        // convert dto to entity
        BidsEntity bidEnt = dtoToEntity(bidsDto);
        BidsEntity savedBid=bidsRepository.save(bidEnt);
       
        // convert CustomerEntity to CustomerDto
        BidsDto bidsDto1=EntityToDto(savedBid);
        
        return bidsDto1;
	}

	@Override
	public List<BidsDto> getAllBidsOnProduct(Long porductId) {
        List<BidsEntity> allBidsAsEntlist = bidsRepository.findAll();
        List<BidsDto> listAsDto=new ArrayList<>();
        for (BidsEntity bidEnt : allBidsAsEntlist ) {
            BidsDto item=EntityToDto(bidEnt);
            if(Long.compare(item.getProductId(), porductId)==0){
                listAsDto.add(item);
            }
            
        }
        System.out.println(listAsDto);
		return listAsDto;
     
		
	}

	@Override
	public List<BidsDto> getAllBidsAfterProductBiddingEndDate(Long porductId) {


		return null;
	}

}