import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Posts from '../../components/Post/Posts';
import PostDetails from '../../components/Post/PostDetails';
import AddPost from '../../components/Post/AddPost';

const Dashboard = () => {
  const [posts, setPosts] = useState([]);
  const [title, setTitle] = useState('');
  const [selectedPost, setSelectedPost] = useState(null);

  const loadPosts = () => {
    axios.get('http://localhost:8080/api/posts')
      .then((response) => {
        setPosts(response.data);
      })
      .catch((error) => {
        console.error('Error fetching posts:', error);
      });
  };

  useEffect(() => {
    loadPosts();
  }, []);

  const handleChangeTitle = () => {
    if (title.trim() === '') {
      return;
    }

    const updatedPosts = posts.map(post =>
      post.id === 111 ? { ...post, title: title } : post
    );
    setPosts(updatedPosts);
  };

  const handleSelectPost = (post) => {
    setSelectedPost(post);
  };

  const handleDeletePost = (postId) => {
    setPosts(posts.filter(post => post.id !== postId));
    setSelectedPost(null); // Deselect the post if it was the one being viewed
  };

  const handlePostAdded = (newPost) => {
    setPosts([...posts, newPost]); // Add the new post to the state
  };

  return (
    <div className="container">
      <AddPost onPostAdded={handlePostAdded} /> {/* Add AddPost component */}
      <Posts posts={posts} onSelectPost={handleSelectPost} />
      <input 
        type="text" 
        value={title} 
        onChange={(e) => setTitle(e.target.value)} 
        placeholder="Title" 
      />
      <button onClick={handleChangeTitle}>Change Title</button>
      {selectedPost && <PostDetails post={selectedPost} onDeletePost={handleDeletePost} />} {/* Pass the handler to PostDetails */}
    </div>
  );
};

export default Dashboard;
