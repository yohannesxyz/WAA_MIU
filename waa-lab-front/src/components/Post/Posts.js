import React from 'react';
import Post from './Post';

const Posts = ({ posts, onSelectPost }) => {
  return (
    <div className="posts" >
      {posts.map(post => (
        <Post key={post.id} post={post} onSelectPost={onSelectPost} />
      ))}
    </div>
  );
};

export default Posts;
