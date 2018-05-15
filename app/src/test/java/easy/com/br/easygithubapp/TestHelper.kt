package easy.com.br.easygithubapp

class TestHelper {

    companion object {
        val API_RESPONSE =
                "{ \"total_count\": 4665530,\n" +
                "    \"incomplete_results\": false,\n" +
                "    \"items\": [\n" +
                "        {\n" +
                "            \"id\": 22790488,\n" +
                "            \"name\": \"java-design-patterns\",\n" +
                "            \"full_name\": \"iluwatar/java-design-patterns\",\n" +
                "            \"owner\": {\n" +
                "                \"login\": \"iluwatar\",\n" +
                "                \"id\": 582346,\n" +
                "                \"avatar_url\": \"https://avatars1.githubusercontent.com/u/582346?v=4\",\n" +
                "                \"gravatar_id\": \"\",\n" +
                "                \"url\": \"https://api.github.com/users/iluwatar\",\n" +
                "                \"html_url\": \"https://github.com/iluwatar\",\n" +
                "                \"followers_url\": \"https://api.github.com/users/iluwatar/followers\",\n" +
                "                \"following_url\": \"https://api.github.com/users/iluwatar/following{/other_user}\",\n" +
                "                \"gists_url\": \"https://api.github.com/users/iluwatar/gists{/gist_id}\",\n" +
                "                \"starred_url\": \"https://api.github.com/users/iluwatar/starred{/owner}{/repo}\",\n" +
                "                \"subscriptions_url\": \"https://api.github.com/users/iluwatar/subscriptions\",\n" +
                "                \"organizations_url\": \"https://api.github.com/users/iluwatar/orgs\",\n" +
                "                \"repos_url\": \"https://api.github.com/users/iluwatar/repos\",\n" +
                "                \"events_url\": \"https://api.github.com/users/iluwatar/events{/privacy}\",\n" +
                "                \"received_events_url\": \"https://api.github.com/users/iluwatar/received_events\",\n" +
                "                \"type\": \"User\",\n" +
                "                \"site_admin\": false\n" +
                "            },\n" +
                "            \"private\": false,\n" +
                "            \"html_url\": \"https://github.com/iluwatar/java-design-patterns\",\n" +
                "            \"description\": \"Design patterns implemented in Java\",\n" +
                "            \"fork\": false,\n" +
                "            \"url\": \"https://api.github.com/repos/iluwatar/java-design-patterns\",\n" +
                "            \"forks_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/forks\",\n" +
                "            \"keys_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/keys{/key_id}\",\n" +
                "            \"collaborators_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/collaborators{/collaborator}\",\n" +
                "            \"teams_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/teams\",\n" +
                "            \"hooks_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/hooks\",\n" +
                "            \"issue_events_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/issues/events{/number}\",\n" +
                "            \"events_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/events\",\n" +
                "            \"assignees_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/assignees{/user}\",\n" +
                "            \"branches_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/branches{/branch}\",\n" +
                "            \"tags_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/tags\",\n" +
                "            \"blobs_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/git/blobs{/sha}\",\n" +
                "            \"git_tags_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/git/tags{/sha}\",\n" +
                "            \"git_refs_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/git/refs{/sha}\",\n" +
                "            \"trees_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/git/trees{/sha}\",\n" +
                "            \"statuses_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/statuses/{sha}\",\n" +
                "            \"languages_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/languages\",\n" +
                "            \"stargazers_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/stargazers\",\n" +
                "            \"contributors_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/contributors\",\n" +
                "            \"subscribers_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/subscribers\",\n" +
                "            \"subscription_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/subscription\",\n" +
                "            \"commits_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/commits{/sha}\",\n" +
                "            \"git_commits_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/git/commits{/sha}\",\n" +
                "            \"comments_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/comments{/number}\",\n" +
                "            \"issue_comment_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/issues/comments{/number}\",\n" +
                "            \"contents_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/contents/{+path}\",\n" +
                "            \"compare_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/compare/{base}...{head}\",\n" +
                "            \"merges_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/merges\",\n" +
                "            \"archive_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/{archive_format}{/ref}\",\n" +
                "            \"downloads_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/downloads\",\n" +
                "            \"issues_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/issues{/number}\",\n" +
                "            \"pulls_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/pulls{/number}\",\n" +
                "            \"milestones_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/milestones{/number}\",\n" +
                "            \"notifications_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/notifications{?since,all,participating}\",\n" +
                "            \"labels_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/labels{/name}\",\n" +
                "            \"releases_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/releases{/id}\",\n" +
                "            \"deployments_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/deployments\",\n" +
                "            \"created_at\": \"2014-08-09T16:45:18Z\",\n" +
                "            \"updated_at\": \"2018-05-13T13:32:17Z\",\n" +
                "            \"pushed_at\": \"2018-05-12T17:19:03Z\",\n" +
                "            \"git_url\": \"git://github.com/iluwatar/java-design-patterns.git\",\n" +
                "            \"ssh_url\": \"git@github.com:iluwatar/java-design-patterns.git\",\n" +
                "            \"clone_url\": \"https://github.com/iluwatar/java-design-patterns.git\",\n" +
                "            \"svn_url\": \"https://github.com/iluwatar/java-design-patterns\",\n" +
                "            \"homepage\": \"http://java-design-patterns.com\",\n" +
                "            \"size\": 17599,\n" +
                "            \"stargazers_count\": 33364,\n" +
                "            \"watchers_count\": 33364,\n" +
                "            \"language\": \"Java\",\n" +
                "            \"has_issues\": true,\n" +
                "            \"has_projects\": false,\n" +
                "            \"has_downloads\": true,\n" +
                "            \"has_wiki\": true,\n" +
                "            \"has_pages\": true,\n" +
                "            \"forks_count\": 10776,\n" +
                "            \"mirror_url\": null,\n" +
                "            \"archived\": false,\n" +
                "            \"open_issues_count\": 173,\n" +
                "            \"license\": {\n" +
                "                \"key\": \"mit\",\n" +
                "                \"name\": \"MIT License\",\n" +
                "                \"spdx_id\": \"MIT\",\n" +
                "                \"url\": \"https://api.github.com/licenses/mit\"\n" +
                "            },\n" +
                "            \"forks\": 10776,\n" +
                "            \"open_issues\": 173,\n" +
                "            \"watchers\": 33364,\n" +
                "            \"default_branch\": \"master\",\n" +
                "            \"score\": 1\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 7508411,\n" +
                "            \"name\": \"RxJava\",\n" +
                "            \"full_name\": \"ReactiveX/RxJava\",\n" +
                "            \"owner\": {\n" +
                "                \"login\": \"ReactiveX\",\n" +
                "                \"id\": 6407041,\n" +
                "                \"avatar_url\": \"https://avatars1.githubusercontent.com/u/6407041?v=4\",\n" +
                "                \"gravatar_id\": \"\",\n" +
                "                \"url\": \"https://api.github.com/users/ReactiveX\",\n" +
                "                \"html_url\": \"https://github.com/ReactiveX\",\n" +
                "                \"followers_url\": \"https://api.github.com/users/ReactiveX/followers\",\n" +
                "                \"following_url\": \"https://api.github.com/users/ReactiveX/following{/other_user}\",\n" +
                "                \"gists_url\": \"https://api.github.com/users/ReactiveX/gists{/gist_id}\",\n" +
                "                \"starred_url\": \"https://api.github.com/users/ReactiveX/starred{/owner}{/repo}\",\n" +
                "                \"subscriptions_url\": \"https://api.github.com/users/ReactiveX/subscriptions\",\n" +
                "                \"organizations_url\": \"https://api.github.com/users/ReactiveX/orgs\",\n" +
                "                \"repos_url\": \"https://api.github.com/users/ReactiveX/repos\",\n" +
                "                \"events_url\": \"https://api.github.com/users/ReactiveX/events{/privacy}\",\n" +
                "                \"received_events_url\": \"https://api.github.com/users/ReactiveX/received_events\",\n" +
                "                \"type\": \"Organization\",\n" +
                "                \"site_admin\": false\n" +
                "            },\n" +
                "            \"private\": false,\n" +
                "            \"html_url\": \"https://github.com/ReactiveX/RxJava\",\n" +
                "            \"description\": \"RxJava – Reactive Extensions for the JVM – a library for composing asynchronous and event-based programs using observable sequences for the Java VM.\",\n" +
                "            \"fork\": false,\n" +
                "            \"url\": \"https://api.github.com/repos/ReactiveX/RxJava\",\n" +
                "            \"forks_url\": \"https://api.github.com/repos/ReactiveX/RxJava/forks\",\n" +
                "            \"keys_url\": \"https://api.github.com/repos/ReactiveX/RxJava/keys{/key_id}\",\n" +
                "            \"collaborators_url\": \"https://api.github.com/repos/ReactiveX/RxJava/collaborators{/collaborator}\",\n" +
                "            \"teams_url\": \"https://api.github.com/repos/ReactiveX/RxJava/teams\",\n" +
                "            \"hooks_url\": \"https://api.github.com/repos/ReactiveX/RxJava/hooks\",\n" +
                "            \"issue_events_url\": \"https://api.github.com/repos/ReactiveX/RxJava/issues/events{/number}\",\n" +
                "            \"events_url\": \"https://api.github.com/repos/ReactiveX/RxJava/events\",\n" +
                "            \"assignees_url\": \"https://api.github.com/repos/ReactiveX/RxJava/assignees{/user}\",\n" +
                "            \"branches_url\": \"https://api.github.com/repos/ReactiveX/RxJava/branches{/branch}\",\n" +
                "            \"tags_url\": \"https://api.github.com/repos/ReactiveX/RxJava/tags\",\n" +
                "            \"blobs_url\": \"https://api.github.com/repos/ReactiveX/RxJava/git/blobs{/sha}\",\n" +
                "            \"git_tags_url\": \"https://api.github.com/repos/ReactiveX/RxJava/git/tags{/sha}\",\n" +
                "            \"git_refs_url\": \"https://api.github.com/repos/ReactiveX/RxJava/git/refs{/sha}\",\n" +
                "            \"trees_url\": \"https://api.github.com/repos/ReactiveX/RxJava/git/trees{/sha}\",\n" +
                "            \"statuses_url\": \"https://api.github.com/repos/ReactiveX/RxJava/statuses/{sha}\",\n" +
                "            \"languages_url\": \"https://api.github.com/repos/ReactiveX/RxJava/languages\",\n" +
                "            \"stargazers_url\": \"https://api.github.com/repos/ReactiveX/RxJava/stargazers\",\n" +
                "            \"contributors_url\": \"https://api.github.com/repos/ReactiveX/RxJava/contributors\",\n" +
                "            \"subscribers_url\": \"https://api.github.com/repos/ReactiveX/RxJava/subscribers\",\n" +
                "            \"subscription_url\": \"https://api.github.com/repos/ReactiveX/RxJava/subscription\",\n" +
                "            \"commits_url\": \"https://api.github.com/repos/ReactiveX/RxJava/commits{/sha}\",\n" +
                "            \"git_commits_url\": \"https://api.github.com/repos/ReactiveX/RxJava/git/commits{/sha}\",\n" +
                "            \"comments_url\": \"https://api.github.com/repos/ReactiveX/RxJava/comments{/number}\",\n" +
                "            \"issue_comment_url\": \"https://api.github.com/repos/ReactiveX/RxJava/issues/comments{/number}\",\n" +
                "            \"contents_url\": \"https://api.github.com/repos/ReactiveX/RxJava/contents/{+path}\",\n" +
                "            \"compare_url\": \"https://api.github.com/repos/ReactiveX/RxJava/compare/{base}...{head}\",\n" +
                "            \"merges_url\": \"https://api.github.com/repos/ReactiveX/RxJava/merges\",\n" +
                "            \"archive_url\": \"https://api.github.com/repos/ReactiveX/RxJava/{archive_format}{/ref}\",\n" +
                "            \"downloads_url\": \"https://api.github.com/repos/ReactiveX/RxJava/downloads\",\n" +
                "            \"issues_url\": \"https://api.github.com/repos/ReactiveX/RxJava/issues{/number}\",\n" +
                "            \"pulls_url\": \"https://api.github.com/repos/ReactiveX/RxJava/pulls{/number}\",\n" +
                "            \"milestones_url\": \"https://api.github.com/repos/ReactiveX/RxJava/milestones{/number}\",\n" +
                "            \"notifications_url\": \"https://api.github.com/repos/ReactiveX/RxJava/notifications{?since,all,participating}\",\n" +
                "            \"labels_url\": \"https://api.github.com/repos/ReactiveX/RxJava/labels{/name}\",\n" +
                "            \"releases_url\": \"https://api.github.com/repos/ReactiveX/RxJava/releases{/id}\",\n" +
                "            \"deployments_url\": \"https://api.github.com/repos/ReactiveX/RxJava/deployments\",\n" +
                "            \"created_at\": \"2013-01-08T20:11:48Z\",\n" +
                "            \"updated_at\": \"2018-05-13T11:24:05Z\",\n" +
                "            \"pushed_at\": \"2018-05-09T17:30:06Z\",\n" +
                "            \"git_url\": \"git://github.com/ReactiveX/RxJava.git\",\n" +
                "            \"ssh_url\": \"git@github.com:ReactiveX/RxJava.git\",\n" +
                "            \"clone_url\": \"https://github.com/ReactiveX/RxJava.git\",\n" +
                "            \"svn_url\": \"https://github.com/ReactiveX/RxJava\",\n" +
                "            \"homepage\": \"\",\n" +
                "            \"size\": 54403,\n" +
                "            \"stargazers_count\": 32958,\n" +
                "            \"watchers_count\": 32958,\n" +
                "            \"language\": \"Java\",\n" +
                "            \"has_issues\": true,\n" +
                "            \"has_projects\": true,\n" +
                "            \"has_downloads\": true,\n" +
                "            \"has_wiki\": true,\n" +
                "            \"has_pages\": true,\n" +
                "            \"forks_count\": 5772,\n" +
                "            \"mirror_url\": null,\n" +
                "            \"archived\": false,\n" +
                "            \"open_issues_count\": 38,\n" +
                "            \"license\": {\n" +
                "                \"key\": \"apache-2.0\",\n" +
                "                \"name\": \"Apache License 2.0\",\n" +
                "                \"spdx_id\": \"Apache-2.0\",\n" +
                "                \"url\": \"https://api.github.com/licenses/apache-2.0\"\n" +
                "            },\n" +
                "            \"forks\": 5772,\n" +
                "            \"open_issues\": 38,\n" +
                "            \"watchers\": 32958,\n" +
                "            \"default_branch\": \"2.x\",\n" +
                "            \"score\": 1\n" +
                "        }"+
                "   ]" +
                "}"
    }
}