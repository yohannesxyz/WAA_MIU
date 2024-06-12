import React from 'react';
import Post from './Post';

const Posts = ({ posts, onSelectPost }) => {
  return (
    <div >
      {posts.map(post => (
        <Post key={post.id} post={post} onSelectPost={onSelectPost} />
      ))}
    </div>
  );
};

export default Posts;
