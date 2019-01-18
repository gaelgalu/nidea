
export default class Idea{
  _id: string;
  title: string;
  content: string;
  tags: string;
  author: string;
  likes: number;
  creationDate: string;
  publishedCommentaries: Comment[];
}
