import React from 'react';

const Post = ({ post, onSelectPost }) => {
  return (
    <div 
      style={{ backgroundColor: 'blue', color: 'white', margin: '10px', padding: '10px' }}
      onClick={() => onSelectPost(post)}  
    >
      <p>{post.id}</p>
      <h2>{post.title}</h2>
      <p>{post.author}</p>
    </div>
  );
};

export default Post;
