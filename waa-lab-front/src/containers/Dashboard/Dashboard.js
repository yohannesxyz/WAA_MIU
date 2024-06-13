import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Posts from '../../components/Post/Posts';
import PostDetails from '../../components/Post/PostDetails';
import AddPost from '../../components/Post/AddPost';
import EditPost from '../../components/Post/EditPost';

const Dashboard = () => {
  const [posts, setPosts] = useState([]);
  const [title, setTitle] = useState('');
  const [selectedPost, setSelectedPost] = useState(null);
  const [editingPost, setEditingPost] = useState(null);
  const [reloadPosts, setReloadPosts] = useState(false); // State variable to trigger reload

  useEffect(() => {
    loadPosts();
  }, [reloadPosts]); // Reload posts whenever reloadPosts changes

  const loadPosts = () => {
    axios.get('http://localhost:8080/api/posts')
      .then((response) => {
        setPosts(response.data);
      })
      .catch((error) => {
        console.error('Error fetching posts:', error);
      });
  };

  const handleChangeTitle = () => {
    if (title.trim() === '') {
      return;
    }

    const updatedPosts = posts.map(post =>
      post.id === 1 ? { ...post, title: title } : post
    );
    setPosts(updatedPosts);
  };

  const handleSelectPost = (post) => {
    setSelectedPost(post);
  };

  const handleDeletePost = (postId) => {
    setPosts(posts.filter(post => post.id !== postId));
    setSelectedPost(null);
  };

  const handlePostAdded = (newPost) => {
    setPosts([...posts, newPost]);
    setReloadPosts(prev => !prev); // Trigger reload of posts
  };

  const handleEditPost = (post) => {
    setEditingPost(post);
  };

  const handleUpdatePost = (updatedPost) => {
    setReloadPosts(prev => !prev); // Toggle reloadPosts to trigger useEffect
    setEditingPost(null);
    setSelectedPost(updatedPost); // Ensure the updated post is selected
  };

  const handleCancelEdit = () => {
    setEditingPost(null);
  };

  return (
    <div className="container">
      <AddPost onPostAdded={handlePostAdded} />
      <Posts posts={posts} onSelectPost={handleSelectPost} />
      <input 
        type="text" 
        value={title} 
        onChange={(e) => setTitle(e.target.value)} 
        placeholder="Title" 
      />
      <button onClick={handleChangeTitle}>Change Title</button>
      {selectedPost && !editingPost && <PostDetails post={selectedPost} onDeletePost={handleDeletePost} onEditPost={handleEditPost} />}
      {editingPost && <EditPost post={editingPost} onUpdatePost={handleUpdatePost} onCancel={handleCancelEdit} />}
    </div>
  );
};

export default Dashboard;
