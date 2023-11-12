//package com.scribbledtech.grpc_product_service.grpc_service;
//
//
//import com.scribbledtech.grpc_product_service.product.ProductGrpc;
//import com.scribbledtech.grpc_product_service.product.ProductOuterClass;
//import io.grpc.stub.StreamObserver;
//
//import net.devh.boot.grpc.server.service.GrpcService;
//
//@GrpcService
//public class ProductServiceImpl extends ProductGrpc.ProductImplBase {
//
//    @Override
//    public void getProductInfo(ProductOuterClass.ProductIdRequest request, StreamObserver<ProductOuterClass.ProductInfoResponse> responseObserver) {
//        int productId = request.getProductId();
//
//        // Create the response
//       ProductOuterClass.ProductInfoResponse response = ProductOuterClass.ProductInfoResponse.newBuilder()
//                .setName("Product " + productId)
//                .setDescription("Description " + productId)
//                .setPrice(productId)
//                .setQuantity(productId)
//                .build();
//
//        // Send the response back to the client
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//    }
//}