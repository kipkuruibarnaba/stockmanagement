//package com.stockmanagement.controller;
//
//import com.springboot.blog.payload.CommentDto;
//import com.springboot.blog.service.CommentService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
///**
// * @author Barnaba Mutai
// * Created on Saturday, July , 09, 2022
// */
//@RestController
//@RequestMapping("/api/")
//public class UserController {
//  private CommentService commentService;
//
//  public UserController(CommentService commentService) {
//    this.commentService = commentService;
//  }
//  @PostMapping("/posts/{postId}/comments")
//  public ResponseEntity<CommentDto> createComment(@PathVariable (value = "postId") long postId, @Valid @RequestBody CommentDto commentDto){
//    return new ResponseEntity<>(commentService.createComment(postId,commentDto), HttpStatus.CREATED);
//  }
//  @GetMapping("/posts/{postId}/comments")
// public List<CommentDto> getCommentsByPostId(@PathVariable(value = "postId") Long postId){
//    return commentService.getCommentsByPostId(postId);
// }
// @GetMapping("/posts/{postId}/comments/{id}")
// public ResponseEntity<CommentDto> getCommentById(@PathVariable(value = "postId") Long postId,
//                                                   @PathVariable(value = "id") Long commentId) {
//  CommentDto commentDto = commentService.getCommentById(postId,commentId);
//  return new ResponseEntity<>(commentDto, HttpStatus.OK);
// }
// @PutMapping("/posts/{postId}/comments/{commentId}")
// public ResponseEntity<CommentDto> updateComment(@PathVariable(value = "postId") Long postId,
//                                                 @PathVariable(value = "commentId") Long commentId,
//                                                 @Valid  @RequestBody CommentDto reqcommentDto){
//CommentDto updatedComment = commentService.updateComment(postId,commentId,reqcommentDto);
//    return new ResponseEntity<>(updatedComment,HttpStatus.OK);
//
// }
//@DeleteMapping("/posts/{postId}/comments/{commentId}")
//public  ResponseEntity<String> deleteComment(@PathVariable(value = "postId") Long postId,
//                                             @PathVariable(value = "commentId") Long commentId){
//   commentService.deleteComment(postId,commentId);
//   return  new ResponseEntity<>("Comment deleted successfully",HttpStatus.OK);
//}
//
//
//}
